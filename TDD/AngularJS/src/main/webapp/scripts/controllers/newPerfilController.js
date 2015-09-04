
angular.module('angularJS').controller('NewPerfilController', function ($scope, $location, locationParser, PerfilResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.perfil = $scope.perfil || {};
    
    $scope.perfilList = [
        "ADMINISTRADOR",
        "ADVOGADO",
        "ALUNO",
        "CANDIDATO",
        "CONTRATANTE",
        "CONVENIADO",
        "FINANCEIRO",
        "FORNECEDOR",
        "INTERESSADO",
        "INSTRUTOR",
        "INSTRUTORREPO",
        "SECRETARIO",
        "VENDEDOR"
    ];
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Perfils/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        PerfilResource.save($scope.perfil, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Perfils");
    };
});