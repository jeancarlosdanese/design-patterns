'use strict';

angular.module('angularJS',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Enderecos',{templateUrl:'views/Endereco/search.html',controller:'SearchEnderecoController'})
      .when('/Enderecos/new',{templateUrl:'views/Endereco/detail.html',controller:'NewEnderecoController'})
      .when('/Enderecos/edit/:EnderecoId',{templateUrl:'views/Endereco/detail.html',controller:'EditEnderecoController'})
      .when('/EnderecoEmails',{templateUrl:'views/EnderecoEmail/search.html',controller:'SearchEnderecoEmailController'})
      .when('/EnderecoEmails/new',{templateUrl:'views/EnderecoEmail/detail.html',controller:'NewEnderecoEmailController'})
      .when('/EnderecoEmails/edit/:EnderecoEmailId',{templateUrl:'views/EnderecoEmail/detail.html',controller:'EditEnderecoEmailController'})
      .when('/Members',{templateUrl:'views/Member/search.html',controller:'SearchMemberController'})
      .when('/Members/new',{templateUrl:'views/Member/detail.html',controller:'NewMemberController'})
      .when('/Members/edit/:MemberId',{templateUrl:'views/Member/detail.html',controller:'EditMemberController'})
      .when('/Perfils',{templateUrl:'views/Perfil/search.html',controller:'SearchPerfilController'})
      .when('/Perfils/new',{templateUrl:'views/Perfil/detail.html',controller:'NewPerfilController'})
      .when('/Perfils/edit/:PerfilId',{templateUrl:'views/Perfil/detail.html',controller:'EditPerfilController'})
      .when('/Pessoas',{templateUrl:'views/Pessoa/search.html',controller:'SearchPessoaController'})
      .when('/Pessoas/new',{templateUrl:'views/Pessoa/detail.html',controller:'NewPessoaController'})
      .when('/Pessoas/edit/:PessoaId',{templateUrl:'views/Pessoa/detail.html',controller:'EditPessoaController'})
      .when('/Telefones',{templateUrl:'views/Telefone/search.html',controller:'SearchTelefoneController'})
      .when('/Telefones/new',{templateUrl:'views/Telefone/detail.html',controller:'NewTelefoneController'})
      .when('/Telefones/edit/:TelefoneId',{templateUrl:'views/Telefone/detail.html',controller:'EditTelefoneController'})
      .when('/Usuarios',{templateUrl:'views/Usuario/search.html',controller:'SearchUsuarioController'})
      .when('/Usuarios/new',{templateUrl:'views/Usuario/detail.html',controller:'NewUsuarioController'})
      .when('/Usuarios/edit/:UsuarioId',{templateUrl:'views/Usuario/detail.html',controller:'EditUsuarioController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
