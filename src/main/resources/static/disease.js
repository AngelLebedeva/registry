var app = angular.module("DiseaseManagement", []);

// Controller Part
app.controller("DiseaseController", function($scope, $http) {


    $scope.disease = [];
    $scope.diseaseForm = {
        disId: 1,
        disName: "",
        disGroup: ""
    };

    _refreshDiseaseData();


    $scope.submitDisease = function () {
        var method = "";
        var url = "";

        if ($scope.diseaseForm.disId == -1) {
            method = "POST";
            url = '/disease';
        } else {
            method = "PUT";
            url = '/disease';
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.diseaseForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createDisease = function () {
        _clearFormData();
    }

    $scope.deleteDisease = function (disease) {
        $http({
            method: "DELETE",
            url: '/disease/' + disease.disId
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editDisease = function (disease) {
        $scope.diseaseForm.disId = disease.disId;
        $scope.diseaseForm.disName = disease.disName;
        $scope.diseaseForm.disGroup= disease.disGroup;

    };

        $scope.reset = function(){
            $scope.disName = validDisName;
            $scope.disGroup = validDisGroup;
        }
        $scope.checkData = function() {
            if ($scope.disName != validDisName || $scope.name != validDisName) {
                alert("Предоставленные данные не совпадают");
            } else {
                alert("Вроде нормально!");
            }
        }

    function _refreshDiseaseData() {
        $http({
            method: 'GET',
            url: '/diseases'
        }).then(
            function (res) { // success
                $scope.diseases = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshDiseaseData();
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
        $scope.diseaseForm.disId = -1;
        $scope.diseaseForm.disName = "";
        $scope.diseaseForm.disGroup = ""

    };
});