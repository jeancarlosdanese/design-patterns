

angular.module('angularJS').controller('EditUsuarioController', function($scope, $routeParams, $location, UsuarioResource , PerfilResource, PessoaResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.usuario = new UsuarioResource(self.original);
            PerfilResource.queryAll(function(items) {
                $scope.perfisSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.perfil
                    };
                    if($scope.usuario.perfis){
                        $.each($scope.usuario.perfis, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.perfisSelection.push(labelObject);
                                $scope.usuario.perfis.push(wrappedObject);
                            }
                        });
                        self.original.perfis = $scope.usuario.perfis;
                    }
                    return labelObject;
                });
            });
            PessoaResource.queryAll(function(items) {
                $scope.pessoaSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.nome
                    };
                    if($scope.usuario.pessoa && item.id == $scope.usuario.pessoa.id) {
                        $scope.pessoaSelection = labelObject;
                        $scope.usuario.pessoa = wrappedObject;
                        self.original.pessoa = $scope.usuario.pessoa;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            $location.path("/Usuarios");
        };
        UsuarioResource.get({UsuarioId:$routeParams.UsuarioId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.usuario);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.usuario.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Usuarios");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Usuarios");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.usuario.$remove(successCallback, errorCallback);
    };
    
    $scope.perfisSelection = $scope.perfisSelection || [];
    $scope.$watch("perfisSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.usuario) {
            $scope.usuario.perfis = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.usuario.perfis.push(collectionItem);
            });
        }
    });
    $scope.$watch("pessoaSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.usuario.pessoa = {};
            $scope.usuario.pessoa.id = selection.value;
        }
    });
    
    $scope.get();
});