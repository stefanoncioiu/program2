(function () {
    'use strict';

    angular
        .module('app')
        .controller('MainCtrl', MainCtrl);

    MainCtrl.$inject = ['$scope','$window', 'RequestService','$routeParams'];

    function MainCtrl($scope,$window, RequestService,$routeParams) {

        var vm = this;
        vm.loginid=$routeParams.loginId;
        vm.projectAuthor = null;
        vm.projectName = null;
        vm.viewLocation = 'src/pages/main/main.template.html';

        vm.loadConfig = function () {
            RequestService
                .initConfig()
                .then(function (res) {
                    vm.projectAuthor = res.data.projectAuthor || 'Unknown';
                    vm.projectName = res.data.projectName || 'Unknown';
                    vm.projectWebsite = res.data.projectWebsite || 'Unknown';
                }, function () {
                    vm.projectAuthor = vm.projectName = 'Error!';
                });
        };

        vm.getForum = function () {
            RequestService
                .getForum()
                .then(function (res) {
                    $scope.todos=res.data;
                }, function () {
                    $scope.todos=[];
                });
        };





        vm.getForum();
        vm.loadConfig();




        return vm;
    }

})();