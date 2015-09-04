angular.module('angularJS').factory('EnderecoResource', function($resource){
    var resource = $resource('rest/enderecos/:EnderecoId',{EnderecoId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});