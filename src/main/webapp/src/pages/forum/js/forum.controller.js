(function () {
    'use strict';

    angular
        .module('app')
        .controller('ForumCtrl', ForumCtrl);

    ForumCtrl.$inject = ['$scope','$window', 'RequestService','$routeParams'];

    function ForumCtrl($scope,$window, RequestService,$routeParams) {

            RequestService
                .getForumID($routeParams.todoId)
                .then(function (res) {
                    $scope.todo=res.data;
                }, function () {
                    $scope.todo=[];
                });

        RequestService
            .getForumComments($routeParams.todoId)
            .then(function (res) {
                $scope.todocom=res.data;
            }, function () {
                $scope.todocom=[];
            });

        $scope.addCommentFunction = function() {
            RequestService.addComment($scope.todo.comment, $routeParams.todoId,$routeParams.loginId)
                .then(function () {
                    window.location.reload();


                }, function () {

                    window.alert("ceva nu e bine");
                });
        }

        $scope.goToHome = function() {
            window.location.href='#/main/'+$routeParams.loginId;



        }

        if($routeParams.loginId>0)
            $scope.updateButton = true;

        $scope.goEvent = function(){


        }




}






})();