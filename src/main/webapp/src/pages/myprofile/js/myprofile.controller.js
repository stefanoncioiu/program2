(function () {
    'use strict';

    angular
        .module('app')
        .controller('MyprofileCtrl', MyprofileCtrl);

    MyprofileCtrl.$inject = ['$scope', '$window', 'RequestService','$routeParams'];

    function MyprofileCtrl($scope,$window, RequestService,$routeParams) {

        var vm = this;
        $scope.visibleInput=null;
        vm.loginid = $routeParams.loginId;
        vm.viewLocation = 'src/pages/myprofile/myprofile.template.html';

        vm.getProfile = function () {
            RequestService
                .getMyProfile(vm.loginid)
                .then(function (res) {
                    $scope.todos = res.data;
                }, function () {
                    $scope.todos = [];
                });
        };
        $scope.deleteFunction = deleteFunction;

        function deleteFunction(id) {
            RequestService.deleteFromForum(id)
                .then(function (res) {

                    window.alert("Sters cu succes");
                    window.location.reload();


                }, function () {
                    window.alert("ceva nu bun");
                });
        }

        $scope.goToHome = function() {
            window.location.href = '#/main/' + $routeParams.loginId;


        }


        $scope.editButton = function(id) {
            $scope.visibleInput=id;


        }

        $scope.updateForumFunction = updateForumFunction;

        function updateForumFunction(id,inp,cont,prio) {
            RequestService.updateForum(id,inp,cont,prio)
                .then(function (res) {
                    window.alert("Update succes");
                    window.location.reload();

                }, function () {
                    window.alert("ceva nu bun");
                });
        }


        vm.getProfile();
        return vm;
    }

})();