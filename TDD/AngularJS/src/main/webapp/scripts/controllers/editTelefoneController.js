

angular.module('angularJS').controller('EditTelefoneController', function($scope, $routeParams, $location, TelefoneResource , PessoaResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.telefone = new TelefoneResource(self.original);
            PessoaResource.queryAll(function(items) {
                $scope.pessoaSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.nome
                    };
                    if($scope.telefone.pessoa && item.id == $scope.telefone.pessoa.id) {
                        $scope.pessoaSelection = labelObject;
                        $scope.telefone.pessoa = wrappedObject;
                        self.original.pessoa = $scope.telefone.pessoa;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            $location.path("/Telefones");
        };
        TelefoneResource.get({TelefoneId:$routeParams.TelefoneId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.telefone);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.telefone.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Telefones");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Telefones");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.telefone.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("pessoaSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.telefone.pessoa = {};
            $scope.telefone.pessoa.id = selection.value;
        }
    });
    $scope.tipoList = [
        "CELULAR",  
        "CASA",  
        "TRABALHO",  
        "PRINCIPAL",  
        "FAX_DO_TRABALHO",  
        "FAX_DE_CASA",  
        "PAGER",  
        "OUTRO"  
    ];
    
    $scope.get();
});