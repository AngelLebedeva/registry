var app = angular.module("RegistrationManagement", []);

// Controller Part
app.controller("RegistrationController", function($scope, $http) {

    $scope.registrations = [];
    $scope.registrationForm = {
        regId: 1,
        position: "",
        docSurname: "",
        patSurname: "",
        visDate: "",
        visTime: ""
    };

        _refreshRegistrationData();

        $scope.submitRegistration = function () {
        var method = "";
        var url = "";

        if ($scope.registrationForm.regId == -1) {
            method = "POST";
            url = '/registration';
        } else {
            method = "PUT";
            url = '/registration';
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.registrationForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createRegistration = function () {
        _clearFormData();
    }


    $scope.deleteRegistration = function (registration) {
        $http({
            method: "DELETE",
            url: '/registration/' + registration.regId
        }).then(_success, _error);
    };

       $scope.editRegistration = function (registration) {
        $scope.registrationForm.regId = registration.regId;
        $scope.registrationForm.position = registration.position;
           $scope.registrationForm.docSurname = registration.docSurname;
           $scope.registrationForm.patSurname = registration.patSurname;
           $scope.registrationForm.visDate = registration.visDate;
           $scope.registrationForm.visTime = registration.visTime;

    };

        $scope.reset = function(){
            $scope.regId = validRegId;
            $scope.position = validPosition;
            $scope.docSurname = validDocSurname;
            $scope.patSurname = validPatSurname;
            $scope.visDate = validVisDate;
            $scope.visTime = validVisTime;


        }
        $scope.checkData = function() {
            if ($scope.visDate != validVisDate || $scope.date != validVisDate) {
                alert("Предоставленные данные не совпадают ");
            } else {
                alert("Вроде нормально!");
            }
        }

    function _refreshRegistrationData() {
        $http({
            method: 'GET',
            url: '/registrations'
        }).then(
            function (res) { // success
                $scope.registrations = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

        function _success(res) {
            _refreshRegistrationData();
            _clearFormData();
        }

        function _error(res) {
            var data = res.data;
            var status = res.status;
            var header = res.header;
            var config = res.config;
            alert("Error: " + status + ":" + data);
        }

        function _clearFormData() {
            $scope.registrationForm.regId = -1;
            $scope.registrationForm.position = "";
            $scope.registrationForm.docSurname = "";
            $scope.registrationForm.patSurname = "";
            $scope.registrationForm.visDate = "";
            $scope.registrationForm.visTime = ""

        };


       });