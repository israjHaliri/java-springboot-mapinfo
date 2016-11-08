/**
 * Created by israjhaliri on 07/11/16.
 */
app.factory('authInterceptorService', ['$q','$location', function ($q, $location){
    var responseError = function (rejection) {
        console.log("rejection = ",rejection);

        if (rejection.status === 403) {
            $location.path('/');
        }
        return $q.reject(rejection);
    };

    return {
        responseError: responseError
    };
}]);
