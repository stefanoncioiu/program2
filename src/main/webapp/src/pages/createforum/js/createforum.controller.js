(function () {
    'use strict';

    angular
        .module('app')
        .controller('CreateForumCtrl', CreateForumCtrl);

    CreateForumCtrl.$inject = ['$scope','$window', 'RequestService','$routeParams'];

    function CreateForumCtrl($scope, $window, RequestService,$routeParams) {
        var vm = this;
        vm.viewLocation = 'src/pages/createforum/createforum.template.html';

        vm.loginId=$routeParams.loginId;
        $scope.createForumFunction = createForumFunction;

        function createForumFunction() {
            RequestService.addContent($scope.todo.namef,$scope.todo.contentf,vm.loginId,$scope.priority.name)
                .then(function () {


                    window.location.href='#/main/'+vm.loginId;


                }, function () {
                    window.alert("wrong content type");
                });
        }

        //vm.loginFunction();

        return vm;
    }

})();

