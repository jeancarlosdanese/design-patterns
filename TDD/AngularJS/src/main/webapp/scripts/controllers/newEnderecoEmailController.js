
angular.module('angularJS').controller('NewEnderecoEmailController', function ($scope, $location, locationParser, EnderecoEmailResource , PessoaResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.enderecoEmail = $scope.enderecoEmail || {};
    
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
            $scope.enderecoEmail.pessoa = {};
            $scope.enderecoEmail.pessoa.id = selection.value;
        }
    });
    
    $scope.tipoList = [
        "CASA",
        "TRABALHO",
        "OUTRO"
    ];
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/EnderecoEmails/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        EnderecoEmailResource.save($scope.enderecoEmail, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/EnderecoEmails");
    };
});