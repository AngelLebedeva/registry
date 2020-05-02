var app = angular.module("PatientManagement", []);

// Controller Part
app.controller("PatientController", function($scope, $http) {

    $scope.patients = [];
    $scope.patientForm = {
        patId: 1,
        patSurname: "",
        patName: "",
        patPatronymic: "",
        patMedicalCardNumber: "",
        patDateOfBirth: "",
        patGender: ""
    };

    _refreshPatientData();

    // HTTP POST/PUT methods for add/edit patient
    // Call: http://localhost:8080/patient
    $scope.submitPatient = function () {
        var method = "";
        var url = "";

        if ($scope.patientForm.patId == -1) {
            method = "POST";
            url = '/patient';
        } else {
            method = "PUT";
            url = '/patient';
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.patientForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createPatient = function () {
        _clearFormData();
    }

    // HTTP DELETE- delete patient by Id
    // Call: http://localhost:8080/patient/{patId}
    $scope.deletePatient = function (patient) {
        $http({
            method: "DELETE",
            url: '/patient/' + patient.patId
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editPatient = function (patient) {
        $scope.patientForm.patId = patient.patId;
        $scope.patientForm.patSurname = patient.patSurname;
        $scope.patientForm.patName = patient.patName;
        $scope.patientForm.patPatronymic = patient.patPatronymic;
        $scope.patientForm.patMedicalCardNumber = patient.patMedicalCardNumber;
        $scope.patientForm.patDateOfBirth = patient.patDateOfBirth;
        $scope.patientForm.patGender = patient.patGender;
    };

        $scope.reset = function(){
            $scope.patSurname = validPatSurname;
            $scope.patName = validPatName;
            $scope.patPatronymic = validPatPatronymic;
            $scope.patMedicalCardNumber = validPatMedicalCardNumber;
            $scope.patDateOfBirth = validPatDateOfBirth;
            $scope.patGender = validPatGender;

        }
        $scope.checkData = function() {
            if ($scope.patSurname != validPatSurname || $scope.surname != validPatSurname) {
                alert("Предоставленные данные не совпадают");
            } else {
                alert("Вроде нормально!");
            }
        }

    function _refreshPatientData() {
        $http({
            method: 'GET',
            url: '/patients'
        }).then(
            function (res) { // success
                $scope.patients = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshPatientData();
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        $scope.patientForm.patId = -1;
        $scope.patientForm.patSurname = "";
        $scope.patientForm.patName = "";
        $scope.patientForm.patPatronymic = "";
        $scope.patientForm.patMedicalCardNumber = "";
        $scope.patientForm.patDateOfBirth = "";
        $scope.patientForm.patGender = ""

    };
});