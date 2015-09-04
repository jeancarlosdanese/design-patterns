
angular.module('angularJS').controller('NewTelefoneController', function ($scope, $location, locationParser, TelefoneResource , PessoaResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.telefone = $scope.telefone || {};
    
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
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Telefones/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        TelefoneResource.save($scope.telefone, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Telefones");
    };
});