angular.module('angularJS').factory('MemberResource', function($resource){
    var resource = $resource('rest/members/:MemberId',{MemberId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});