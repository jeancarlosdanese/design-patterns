

angular.module('angularJS').controller('EditPerfilController', function($scope, $routeParams, $location, PerfilResource ) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.perfil = new PerfilResource(self.original);
        };
        var errorCallback = function() {
            $location.path("/Perfils");
        };
        PerfilResource.get({PerfilId:$routeParams.PerfilId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.perfil);
    };

    $scope.save = function() {
        var successCallback = function(){
            $scope.get();
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        };
        $scope.perfil.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Perfils");
    };

    $scope.remove = function() {
        var successCallback = function() {
            $location.path("/Perfils");
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError=true;
        }; 
        $scope.perfil.$remove(successCallback, errorCallback);
    };
    
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
    
    $scope.get();
});