angular.module('angularJS').factory('EnderecoEmailResource', function($resource){
    var resource = $resource('rest/enderecoemails/:EnderecoEmailId',{EnderecoEmailId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});