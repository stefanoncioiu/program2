(function () {
    'use strict';

    angular
        .module('app')
        .controller('MainCtrl', MainCtrl);

    MainCtrl.$inject = ['$window', 'RequestService'];

    function MainCtrl($window, RequestService) {

        var vm = this;

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

        vm.getAdmin = function () {
            RequestService
                .getUser('admin')
                .then(function (res) {
                    vm.admin = {
                        username : res.data.userName || 'Unknown',
                        email : res.data.email || 'Unknown',
                        password : res.data.password || 'Unknown'
                    }
                }, function () {
                    vm.adminUserName = vm.adminUserName = 'Error!';
                });
        };

        vm.getAdmin();
        vm.loadConfig();


        return vm;
    }

})();