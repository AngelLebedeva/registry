var app = angular.module("DoctorManagement", []);

// Controller Part
app.controller("DoctorController", function($scope, $http) {

    $scope.doctors = [];
    $scope.doctorForm = {
        docId: 1,
        docNo: "",
        docSurname: "",
        docName: "",
        docPatronymic: "",
        position: "",
        docRecruitment: "",
        docCabinet: ""
    };

    // Now load the data from server
    _refreshDoctorData();

    // HTTP POST/PUT methods for add/edit doctor
    // Call: http://localhost:8080/doctor
    $scope.submitDoctor = function () {
        var method = "";
        var url = "";

        if ($scope.doctorForm.docId == -1) {
            method = "POST";
            url = '/doctor';
        } else {
            method = "PUT";
            url = '/doctor';
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.doctorForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createDoctor = function () {
        _clearFormData();
    }

    // HTTP DELETE- delete doctor by Id
    // Call: http://localhost:8080/doctor/{docId}
    $scope.deleteDoctor = function (doctor) {
        $http({
            method: 'DELETE',
            url: '/doctor/' + doctor.docId
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editDoctor = function (doctor) {
        $scope.doctorForm.docId = doctor.docId;
        $scope.doctorForm.docNo = doctor.docNo;
        $scope.doctorForm.docSurname = doctor.docSurname;
        $scope.doctorForm.docName = doctor.docName;
        $scope.doctorForm.docPatronymic = doctor.docPatronymic;
        $scope.doctorForm.position = doctor.position;
        $scope.doctorForm.docRecruitment = doctor.docRecruitment;
        $scope.doctorForm.docCabinet = doctor.docCabinet;
    };

        $scope.reset = function(){
            $scope.docSurname = validDocSurname;
            $scope.docName = validDocName;
            $scope.docPatronymic = validDocPatronymic;
            $scope.position = validPosition;
            $scope.docRecruitment = validDocRecruitment;
            $scope.docCabinet = validDocCabinet;

        }
        $scope.checkData = function() {
            if ($scope.docSurname != validDocSurname || $scope.surname != validDocSurname) {
                alert("Предоставленные данные не совпадают");
            } else {
                alert("Вроде нормально!");
            }
        }

    function _refreshDoctorData() {
        $http({
            method: 'GET',
            url: '/doctors'
        }).then(
            function (res) { // success
                $scope.doctors = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshDoctorData();
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
        $scope.doctorForm.docId = -1;
        $scope.doctorForm.docNo = "";
        $scope.doctorForm.docSurname = "";
        $scope.doctorForm.docName = "";
        $scope.doctorForm.docPatronymic = "";
        $scope.doctorForm.position = "";
        $scope.doctorForm.docRecruitment = "";
        $scope.doctorForm.docCabinet= ""
    };
});
