(function () {
    'use strict';

    angular
        .module('app')
        .service('RequestService', RequestService);

    RequestService.$inject = ['$http'];

    function RequestService($http) {

        var service = {};

        service.initConfig = function () {
            return $http.get('config');
        };

        service.getUser = function (userName,pass) {
            var requestConfig = {
                params: {userName: userName, password:pass}
            };
            return $http.get('user', requestConfig);
        };

        service.addUser = function (userName,pass,email) {
            var requestConfig = {
                params: {userName: userName, password:pass, email:email}
            };

            return $http.get('putUserIntoDb',requestConfig);
        };

        service.addContent = function (nameForum,content,userid,priority) {
            var requestConfig = {
                params: {nameForum: nameForum, content:content, userid:userid, priority:priority}
            };

            return $http.get('putContentIntoDb',requestConfig);
        };

        service.getForum = function () {
            return $http.get('forum');
        };

        service.getForumID = function (id) {
            var requestConfig = {
                params: {id:id}
            };

            return $http.get('forumid',requestConfig);
        };

        service.addComment = function (comment,id,userid) {
            var requestConfig = {
                params: {comment: comment, id:id, userid: userid}
            };

            return $http.get('putCommentIntoDb',requestConfig);
        };

        service.getForumComments = function (id) {
            var requestConfig = {
                params: { id:id}
            };

            return $http.get('getComments',requestConfig);
        };


        service.getMyProfile= function(id){
            var requestConfig={
                params:{id:id}
            };

            return $http.get('getProfile',requestConfig);
        }

        service.deleteFromForum= function(id){
            var requestConfig={
                params:{id:id}
            };

            return $http.get('deleteFromForum',requestConfig);
        }

        service.updateForum= function(id, nameForum, content, priority){
            var requestConfig={
                params:{id:id,nameForum: nameForum, content:content, priority:priority}
            };

            return $http.get('updateForum',requestConfig);
        }


        return service;
    }

})();