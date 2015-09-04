
angular.module('angularJS').controller('NewEnderecoController', function ($scope, $location, locationParser, EnderecoResource , PessoaResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.endereco = $scope.endereco || {};
    
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
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Enderecos/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        EnderecoResource.save($scope.endereco, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Enderecos");
    };
});