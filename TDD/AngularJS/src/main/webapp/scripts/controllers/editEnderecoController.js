

angular.module('angularJS').controller('EditEnderecoController', function($scope, $routeParams, $location, EnderecoResource , PessoaResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.endereco = new EnderecoResource(self.original);
            PessoaResource.queryAll(function(items) {
                $scope.pessoaSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.nome
                    };
                    if($scope.endereco.pessoa && item.id == $scope.endereco.pessoa.id) {
                        $scope.pessoaSelection = labelObject;
                        $scope.endereco.pessoa = wrappedObject;
                        self.original.pessoa = $scope.endereco.pessoa;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            $location.path("/Enderecos");
        };
        EnderecoResource.get({EnderecoId:$routeParams.EnderecoId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.endereco);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.endereco.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Enderecos");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Enderecos");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.endereco.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("pessoaSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.endereco.pessoa = {};
            $scope.endereco.pessoa.id = selection.value;
        }
    });
    $scope.tipoList = [
        "CASA",  
        "TRABALHO",  
        "OUTRO"  
    ];
    $scope.estadoList = [
        "AC",  
        "AL",  
        "AP",  
        "AM",  
        "BA",  
        "CE",  
        "DF",  
        "ES",  
        "GO",  
        "MA",  
        "MT",  
        "MS",  
        "MG",  
        "PA",  
        "PB",  
        "PR",  
        "PE",  
        "PI",  
        "RJ",  
        "RN",  
        "RS",  
        "RO",  
        "RR",  
        "SC",  
        "SP",  
        "SE",  
        "TO"  
    ];
    
    $scope.get();
});