var app = angular.module("VisitManagement", []);

// Controller Part
app.controller("VisitController", function($scope, $http) {

    $scope.visits = [];
    $scope.visitForm = {
        visId: 1,
        docId: "",
        patId: "",
        visDate: "",
        visTime: "",
        disId: ""

    };

    // Now load the data from server
    _refreshVisitData();

    $scope.submitVisit = function () {
        var method = "";
        var url = "";

        if ($scope.visitForm.visId == -1) {
            method = "POST";
            url = '/visit';
        } else {
            method = "PUT";
            url = '/visit';
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.visitForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createVisit = function () {
        _clearFormData();
    }

    $scope.deleteVisit = function (visit) {
        $http({
            method: "DELETE",
            url: '/visit/' + visit.visId
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editVisit = function (visit) {
        $scope.visitForm.visId = visit.visId;
        $scope.visitForm.docId = visit.docId;
        $scope.visitForm.patId = visit.patId;
        $scope.visitForm.visDate = visit.visDate;
        $scope.visitForm.visTime = visit.visTime;
        $scope.visitForm.disId = visit.disId;

    };

        $scope.reset = function(){
            $scope.docId = validDocId;
            $scope.patId = validPatId;
            $scope.visDate = validVisDate;
            $scope.visTime = validVisTime;
            $scope.disId = validDisId;


        }
        $scope.checkData = function() {
            if ($scope.visDate != validVisDate || $scope.date != validVisDate) {
                alert("Предоставленные данные не совпадают с владельцем по умолчанию");
            } else {
                alert("Вроде нормально!");
            }
        }

    function _refreshVisitData() {
        $http({
            method: 'GET',
            url: '/visits'
        }).then(
            function (res) { // success
                $scope.visits = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshVisitData();
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
        $scope.visitForm.visId = -1;
        $scope.visitForm.docId = "";
        $scope.visitForm.patId = "";
        $scope.visitForm.visDate = "";
        $scope.visitForm.visTime = "";
        $scope.visitForm.disId = ""

    };
});