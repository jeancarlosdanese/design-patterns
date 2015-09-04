angular.module('angularJS').factory('PessoaResource', function($resource){
    var resource = $resource('rest/pessoas/:PessoaId',{PessoaId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});