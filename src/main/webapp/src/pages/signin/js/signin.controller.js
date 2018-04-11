(function () {
    'use strict';

    angular
        .module('app')
        .controller('SigninCtrl', SigninCtrl);

    SigninCtrl.$inject = ['$scope', '$window', 'RequestService'];

    function SigninCtrl($scope,$window, RequestService) {

        var vm = this;
        vm.viewLocation = 'src/pages/signin/signin.template.html';

        $scope.signinFunction = signinFunction;

        function signinFunction() {
            RequestService.addUser($scope.todo.name, $scope.todo.password, $scope.todo.email)
                .then(function () {
                    window.location.href='/';


                }, function () {
                    window.alert("wrong username_signin or password");
                });
        }

        //vm.loginFunction();

        return vm;
    }

})();