
agodaReward = function () {

    //#region Variables

    //Reward object Control
    var _rewardControl = {
        PasswordStrength: null,
        TxtPassword: null,
        PasswordStrengthDisplay: null,
        Text: null
    }

    //DOM attribute
    var _attr = {
        Class: "class"
    }

    //DOM Mouse Event
    var _mouseEvent = {
        KeyUp: "keyup",
        KeyDown: "keydown"
    }

    var _empty = "";

    //#endregion

    //#region methods

    //Initialize Agoda Reward Object
    this.Initialize = function (param) {

        //Set agoda reward parameter
        _rewardControl = param;

        //Set default value
        _AutoPositionPasswordStrength();
        _DefaultPasswordStrength();
    }

    //Automatically password strength position
    var _AutoPositionPasswordStrength = function () {

        //Keydown Event handler password strength position
        $("body").live(_mouseEvent.KeyDown, function () {
            _EventHandlerPasswordStrength();
        });

        //Keyup Event handler password strength position
        $("body").live(_mouseEvent.KeyUp, function () {
            _EventHandlerPasswordStrength();
        });

        _DefaultPasswordStrength
    }

    //Set Password Strength Handler
    var _EventHandlerPasswordStrength = function () {

        //Set text string to password strength displayer DOM
        if ($(_rewardControl.PasswordStrength).text() != _empty)
            $(_rewardControl.PasswordStrengthDisplay).text($(_rewardControl.PasswordStrength).text());

        //Set CSS class name for password strength displayer DOM
        $(_rewardControl.PasswordStrengthDisplay).attr("class", $(_rewardControl.PasswordStrength).attr("class"));

        //Load default password strength function
        _DefaultPasswordStrength();
    }

    //Set default password strength text
    var _DefaultPasswordStrength = function () {

        //Reset Password strength bar to default if value of password is empty
        if ($(_rewardControl.TxtPassword).val() == "") {

            $(_rewardControl.PasswordStrengthDisplay).attr("class", "default");
            $(_rewardControl.PasswordStrengthDisplay).text(_rewardControl.Text);
        }
    }

    //#endregion

}

//#region Variables
var _popupElement = ".rewardAutoPopup";
var _loadingCityListImage = "#loadingCityList";
var _cityTextBox = "#txtCity";
var _preferTextBox = "#txtCityPreferred";
var _preferCityList = "#hdfCityPreferred";
//#endregion

//#region Public Functions

//Validate password strength custom function
function ValidatePasswordStrength(obj, args) {

    //alert($find("passStrength")._getPasswordStrength());
    if ($find("passStrength")._getPasswordStrength() <= 75) {
        args.IsValid = false;
    }
}

//#endregion

//#region Document Ready

$(document).ready(function () {

    DefaultFunction();
    Sys.WebForms.PageRequestManager.getInstance().add_endRequest(EndRequestHandler);
    function EndRequestHandler(sender, args) {
        $(function () {
            DefaultFunction();
        });
    }
});

//#endregion

//#region Methods

var DefaultFunction = function () {

    // Initialize Reward Menu Popup Function
    //Comment for test rtl
    AutoRewardMenuPopup();

    //Initialize Date picker for birthday
    if ($("#txtBirthday").attr("id") != undefined) {

        //Variables
        var _monthName = $("#hdfMonthNameLong").val().split(",");
        var _monthNameShort = $("#hdfMonthNameShort").val().split(",");
        var _dayNameShort = $("#hdfDayNameShort").val().split(",");
        var _rtl = ($("#hdfIsRTL").val() == "true") ? true : false;
        var _buddhist = $("#hdfIsBuddhist").val() == "True";

        //Initialize datepicker function
        $("#txtBirthday").datepicker({
            buttonImage: "https://img.agoda.net/images/default/icon-cal-blue-1.png",
            showOn: "button",
            buttonImageOnly: true,
            dateFormat: "m-d-yy",
            monthNames: _monthName,
            monthNamesShort: _monthNameShort,
            dayNamesMin: _dayNameShort,
            isRTL: _rtl,
            changeYear: true,
            changeMonth: true,
            yearRange: "-100:-0",
            maxDate: new Date()
            //isBuddhist: _buddhist
        });
    }

    //Initialize Controls Event Handler
    controlEventHandler();

    //Hide Loading Images
    $(_loadingCityListImage).hide();
}

// Reward Menu Auto Popup
var AutoRewardMenuPopup = function () {

    var _menuElement = ".rewardMenu";
    HidePopup();

    $(_menuElement).mouseover(function () {

        var _popupHeight = $(_popupElement).height();
        var _sender = $(this);
        var _top = GetMenuPostion($(_sender).attr("id")) - _popupHeight + 10;
        $(_popupElement).css("top", _top);
        ShowPopup();
    });

    $(_menuElement).mouseout(function () {
        HidePopup();
    });
}

var GetMenuPostion = function (id) {
    var node = document.getElementById(id);
    var curtop = 0;
    var curtopscroll = 0;
    if (node.offsetParent) {
        do {
            curtop += node.offsetTop;
            curtopscroll += node.offsetParent ? node.offsetParent.scrollTop : 0;
        } while (node = node.offsetParent);

        return curtop - curtopscroll - node;
    }
}

// Hide popup+-
var HidePopup = function () {

    // Hide popup first
    $(_popupElement).addClass("hide");
    $("#leftpage").css("z-index", "0");
}

//Show Popup
var ShowPopup = function () {

    // Hide popup first
    $("#leftpage").css("z-index", "999");
    $(_popupElement).removeClass("hide");
}

//Event handler controler
var controlEventHandler = function () {
    var _ddlCountry = "#ddlMailingCountry";
    var _ddlCountryPreferred = "#ddlCountryPreferred";
    var _textboxObj = null;

    //Preferred Textbox change event  handler
    $(_preferTextBox).live("keyup", function () {
        CheckCorrectCityName();
    });

    //Choose city name on auto complete popup event handler
    $(".ui-autocomplete").live("click", function () {
        CheckCorrectCityName();
    });


    var CheckCorrectCityName = function () {
        var cityList = "," + JSON.stringify($(_preferCityList).val().toLowerCase()) + ","
        cityList = cityList.replace("\"", "");

        if (cityList != ",,") {
            if (cityList.indexOf("," + $(_preferTextBox).val().toLowerCase() + ",") < 0) {
                CityNotMatched();
            }
            else {
                CityMatched();
            }
        }
        else {
            CityNotMatched();
        }
    }

    var CityNotMatched = function () {
        $(_preferTextBox).addClass("red");
        $("#lbtAddDestination").addClass("hide");
    }

    var CityMatched = function () {
        $(_preferTextBox).removeClass("red");
        $("#lbtAddDestination").removeClass("hide");
    }
}

// Asnychronize data with web method to get city list
var AsyncCityList = function (obj, textbox) {

    $.ajax({
        type: "POST",
        url: "/pages/ajax/GetCityList.aspx",
        data: { countryID: $(obj).val() }
    }).success(function (data) {
        LoadAutoCompleteCity(data, textbox)
    });
}

// Load City list for city text box auto complete
var LoadAutoCompleteCity = function (data, textbox) {
    var cityList = eval(data);

    //Set Auto complete funciton to city textbox
    $(textbox).autocomplete({
        source: cityList,
        minLength: 2
    });

    //Set textbox and image to ready
    $(_loadingCityListImage).hide();
    $(textbox).val("")
    $(textbox).removeAttr("readonly");

    if (textbox == _preferTextBox)
        $(_preferCityList).val(cityList);
}

var NumberOnly = function (val) {
    var strPass = val.value;
    var strLength = strPass.length;
    var lchar = val.value.charAt((strLength) - 1);
    var cCode = CalcKeyCode(lchar);

    if (cCode < 48 || cCode > 57) {
        var myNumber = val.value.substring(0, (strLength) - 1);
        val.value = myNumber;
    }
    return false;
}

//#endregion

//#region Extension Function

//Number only
$.fn.NumberOnly = function () {
    return (NumberOnly, $(this).val());
}

//#endregion

//#region Login Social Network

//#region Declarations
var _socialPopup = null;
//#endregion
function FacebookLogin(param) {
    if (param != "") param = "?" + param
    OpenPopup("/pages/agoda/popup/popup_facebookConnect.aspx" + param);
}

function GoogleLogin(param) {
    if (param != "") param = "?" + param
    OpenPopup("/pages/agoda/popup/popup_googleConnect.aspx" + param);
}

var _socialPopup;

function OpenPopup(url) {
    var w = 500;
    var h = 450;
    var left = (screen.width / 2) - (w / 2);
    var top = (screen.height / 2) - (h / 2);
    _socialPopup = window.open(url, 'newWindow', 'width=' + w + ',height=' + h + ',top=' + top + ',left=' + left, 1);
}

//#endregion

//rewardSslLink = function () {

//    this.Rewriting = function (element) {
//        //        $($("body #wrapper div")).not($(element)).each(function () {
//        //            $(this).find("a").each(function () {
//        //                $(this).attr("href", "http://www.agoda.com");
//        //            });
//        //        });
//        element = "mainpage";
//        $("body>#wrapper>div").each(function () {
//            alert($(this).attr("id"));
//        });
//    }
//}

agodaRewardSession = function () {

    //Variables
    var mask = "#rewardRefreshMask, .refreshSessionImage";
    var timeOut = 1000 * 60 * 30; // 30 minutes
    var lastActivity = new Date().getTime();
    var checkTimeout;

    //Refresh agoda reward session 
    this.RefreshSession = function () {
        $.ajax({
            type: "POST",
            url: "/pages/ajax/CheckRewardSessionExpire.aspx",
            data: {}
        }).success(function (data) {
            if (data == "True")
                rewardSession.ShowReloadMask();
            else
                rewardSession.HideReloadMask();
        });
    }

    //Show refresh reward session mask
    this.ShowReloadMask = function () {
        $(mask).removeClass("hide");
        $("#langselect, #langselect ul, .link_share li").css("z-index", "10");
        setTimeout("location.reload(true);", 2000);
    }

    //Hide refresh reward session mask
    this.HideReloadMask = function () {
        $(mask).addClass("hide");
    }

    this.CheckSessionTimeOut = function () {

        checkTimeOut = function () {
            if (new Date().getTime() > lastActivity + timeOut) {
                this.RefreshSession();
            } else {
                window.setTimeout(checkTimeOut, 1000); // check once per second
            }
            this.RefreshSession();
        }

        $(window).focus(function () {

            //Check is user is logged in
            if ($(".account_email").html() != "") {
                rewardSession.CheckSessionTimeOut();
            }
        });
    }
}

