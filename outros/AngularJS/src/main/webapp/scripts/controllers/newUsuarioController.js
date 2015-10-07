
angular.module('angularJS').controller('NewUsuarioController', function ($scope, $location, locationParser, UsuarioResource , PerfilResource, PessoaResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.usuario = $scope.usuario || {};
    
    $scope.perfisList = PerfilResource.queryAll(function(items){
        $scope.perfisSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.perfil
            });
        });
    });
    $scope.$watch("perfisSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.usuario.perfis = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.usuario.perfis.push(collectionItem);
            });
        }
    });

    $scope.pessoaList = PessoaResource.queryAll(function(items){
        $scope.pessoaSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.nome
            });
        });
    });
    $scope.$watch("pessoaSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.usuario.pessoa = {};
            $scope.usuario.pessoa.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Usuarios/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        UsuarioResource.save($scope.usuario, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Usuarios");
    };
});