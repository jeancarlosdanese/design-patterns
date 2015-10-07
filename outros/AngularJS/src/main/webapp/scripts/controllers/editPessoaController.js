

angular.module('angularJS').controller('EditPessoaController', function($scope, $routeParams, $location, PessoaResource , UsuarioResource, EnderecoEmailResource, EnderecoResource, TelefoneResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.pessoa = new PessoaResource(self.original);
            UsuarioResource.queryAll(function(items) {
                $scope.usuarioSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.perfisAsString
                    };
                    if($scope.pessoa.usuario && item.id == $scope.pessoa.usuario.id) {
                        $scope.usuarioSelection = labelObject;
                        $scope.pessoa.usuario = wrappedObject;
                        self.original.usuario = $scope.pessoa.usuario;
                    }
                    return labelObject;
                });
            });
            EnderecoEmailResource.queryAll(function(items) {
                $scope.emailsSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.tipo
                    };
                    if($scope.pessoa.emails){
                        $.each($scope.pessoa.emails, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.emailsSelection.push(labelObject);
                                $scope.pessoa.emails.push(wrappedObject);
                            }
                        });
                        self.original.emails = $scope.pessoa.emails;
                    }
                    return labelObject;
                });
            });
            EnderecoResource.queryAll(function(items) {
                $scope.enderecosSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.tipo
                    };
                    if($scope.pessoa.enderecos){
                        $.each($scope.pessoa.enderecos, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.enderecosSelection.push(labelObject);
                                $scope.pessoa.enderecos.push(wrappedObject);
                            }
                        });
                        self.original.enderecos = $scope.pessoa.enderecos;
                    }
                    return labelObject;
                });
            });
            TelefoneResource.queryAll(function(items) {
                $scope.telefonesSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.tipo
                    };
                    if($scope.pessoa.telefones){
                        $.each($scope.pessoa.telefones, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.telefonesSelection.push(labelObject);
                                $scope.pessoa.telefones.push(wrappedObject);
                            }
                        });
                        self.original.telefones = $scope.pessoa.telefones;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            $location.path("/Pessoas");
        };
        PessoaResource.get({PessoaId:$routeParams.PessoaId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.pessoa);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.pessoa.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Pessoas");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Pessoas");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.pessoa.$remove(successCallback, errorCallback);
    };
    
    $scope.sexoList = [
        "MASCULINO",  
        "FEMININO"  
    ];
    $scope.tipoPessoaList = [
        "FISICA",  
        "JURIDICA"  
    ];
    $scope.$watch("usuarioSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.pessoa.usuario = {};
            $scope.pessoa.usuario.id = selection.value;
        }
    });
    $scope.emailsSelection = $scope.emailsSelection || [];
    $scope.$watch("emailsSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.pessoa) {
            $scope.pessoa.emails = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.pessoa.emails.push(collectionItem);
            });
        }
    });
    $scope.enderecosSelection = $scope.enderecosSelection || [];
    $scope.$watch("enderecosSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.pessoa) {
            $scope.pessoa.enderecos = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.pessoa.enderecos.push(collectionItem);
            });
        }
    });
    $scope.telefonesSelection = $scope.telefonesSelection || [];
    $scope.$watch("telefonesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.pessoa) {
            $scope.pessoa.telefones = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.pessoa.telefones.push(collectionItem);
            });
        }
    });
    $scope.estadoCivilList = [
        "CASADO",  
        "DESQUITADO",  
        "DIVORCIADO",  
        "SEPARADO",  
        "SOLTEIRO",  
        "VIUVO"  
    ];
    
    $scope.get();
});