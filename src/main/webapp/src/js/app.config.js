(function () {
    'use strict';

    /* Common application conroller */
    angular
        .module('app')
        .config(App);

    App.$inject = ['$routeProvider','$locationProvider'];

    function App($routeProvider, $locationProvider) {
        $locationProvider.hashPrefix('');
    }
})();

