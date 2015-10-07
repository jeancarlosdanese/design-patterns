angular.module('angularJS').factory('PerfilResource', function($resource){
    var resource = $resource('rest/perfils/:PerfilId',{PerfilId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});