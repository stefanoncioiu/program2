(function () {
    'use strict';

    /* Common application conroller */
    angular
        .module('app')
        .controller('ApplicationCtrl', ApplicationCtrl);

    ApplicationCtrl.$inject = ['$window'];

    function ApplicationCtrl($window) {

        return this;
    }
})();

