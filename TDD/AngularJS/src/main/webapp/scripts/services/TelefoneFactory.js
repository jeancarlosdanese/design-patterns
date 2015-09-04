angular.module('angularJS').factory('TelefoneResource', function($resource){
    var resource = $resource('rest/telefones/:TelefoneId',{TelefoneId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});