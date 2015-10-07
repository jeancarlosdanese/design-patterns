

angular.module('angularJS').controller('EditEnderecoEmailController', function($scope, $routeParams, $location, EnderecoEmailResource , PessoaResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.enderecoEmail = new EnderecoEmailResource(self.original);
            PessoaResource.queryAll(function(items) {
                $scope.pessoaSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.nome
                    };
                    if($scope.enderecoEmail.pessoa && item.id == $scope.enderecoEmail.pessoa.id) {
                        $scope.pessoaSelection = labelObject;
                        $scope.enderecoEmail.pessoa = wrappedObject;
                        self.original.pessoa = $scope.enderecoEmail.pessoa;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            $location.path("/EnderecoEmails");
        };
        EnderecoEmailResource.get({EnderecoEmailId:$routeParams.EnderecoEmailId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.enderecoEmail);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.enderecoEmail.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/EnderecoEmails");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/EnderecoEmails");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.enderecoEmail.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("pessoaSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.enderecoEmail.pessoa = {};
            $scope.enderecoEmail.pessoa.id = selection.value;
        }
    });
    $scope.tipoList = [
        "CASA",  
        "TRABALHO",  
        "OUTRO"  
    ];
    
    $scope.get();
});