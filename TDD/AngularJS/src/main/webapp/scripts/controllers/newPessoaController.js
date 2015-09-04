
angular.module('angularJS').controller('NewPessoaController', function ($scope, $location, locationParser, PessoaResource , UsuarioResource, EnderecoEmailResource, EnderecoResource, TelefoneResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.pessoa = $scope.pessoa || {};
    
    $scope.sexoList = [
        "MASCULINO",
        "FEMININO"
    ];
    
    $scope.tipoPessoaList = [
        "FISICA",
        "JURIDICA"
    ];
    
    $scope.usuarioList = UsuarioResource.queryAll(function(items){
        $scope.usuarioSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.perfisAsString
            });
        });
    });
    $scope.$watch("usuarioSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.pessoa.usuario = {};
            $scope.pessoa.usuario.id = selection.value;
        }
    });
    
    $scope.emailsList = EnderecoEmailResource.queryAll(function(items){
        $scope.emailsSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.tipo
            });
        });
    });
    $scope.$watch("emailsSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.pessoa.emails = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.pessoa.emails.push(collectionItem);
            });
        }
    });

    $scope.enderecosList = EnderecoResource.queryAll(function(items){
        $scope.enderecosSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.tipo
            });
        });
    });
    $scope.$watch("enderecosSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.pessoa.enderecos = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.pessoa.enderecos.push(collectionItem);
            });
        }
    });

    $scope.telefonesList = TelefoneResource.queryAll(function(items){
        $scope.telefonesSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.tipo
            });
        });
    });
    $scope.$watch("telefonesSelection", function(selection) {
        if (typeof selection != 'undefined') {
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
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            $location.path('/Pessoas/edit/' + id);
            $scope.displayError = false;
        };
        var errorCallback = function() {
            $scope.displayError = true;
        };
        PessoaResource.save($scope.pessoa, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Pessoas");
    };
});