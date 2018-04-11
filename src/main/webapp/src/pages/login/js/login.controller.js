(function () {
    'use strict';

    angular
        .module('app')
        .controller('LoginCtrl', LoginCtrl);

    LoginCtrl.$inject = ['$scope','$window', 'RequestService','$routeParams'];

    function LoginCtrl($scope, $window, RequestService,$routeParams) {
        var vm = this;
        vm.viewLocation = 'src/pages/login/login.template.html';
        vm.loginID=$routeParams.loginId;
        $scope.loginFunction = loginFunction;

        function loginFunction() {
            RequestService.getUser($scope.todo.name,$scope.todo.password)
                .then(function (res) {
                        $scope.todo=res.data;
                    vm.admin = {
                        username : $scope.todo.name,
                        password : $scope.todo.password
                    }
                    window.alert("Salut "+vm.admin.password);
                window.location.href='#/main/'+$scope.todo.id;


            }, function () {
            window.alert("wrong username or password");
            });
        }

        //vm.loginFunction();

        return vm;
    }

})();

