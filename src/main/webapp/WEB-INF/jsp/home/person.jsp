<%@include file="/WEB-INF/jsp/common/page-includes.jspf" %>
<html>
    <head>
        <title><spring:message code="home.browser.title"/></title>
        <%@include file="/WEB-INF/jsp/common/common-head-elements.jspf" %>
    </head>
    <body>
        <h2>Get Address</h2>

        <form name="getAddress" id="address-form">
            <fieldset>
                <div>
                    <label for="firstName">First Name:</label>
                    <input name="firstName" id="firstName" value=""/>
                </div>
                <div>
                    <label for="lastName">Last Name:</label>
                    <input name="lastName" id="lastName" value=""/>
                </div>
                <input type="submit" value="Get Address" id="address"/>
            </fieldset>
        </form>
        <script type="text/javascript">

            $.fn.serializeObject = function() {
                var o = {};
                var a = this.serializeArray();
                $.each(a, function() {
                    if (o[this.name] !== undefined) {
                        if (!o[this.name].push) {
                            o[this.name] = [o[this.name]];
                        }
                        o[this.name].push(this.value || '');
                    } else {
                        o[this.name] = this.value || '';
                    }
                });
                return o;
            };


            var addressNameSpace = {};

            addressNameSpace.callback = function(data) {
                var items = [];

                items.push('<li id="firstName">' + data.firstName + '</li>');
                items.push('<li id="lastName">' + data.lastName + '</li>');
                items.push('<li id="address1">' + data.address.address1 + '</li>');
                items.push('<li id="city">' + data.address.city + '</li>');
                items.push('<li id="state">' + data.address.state + '</li>');
                items.push('<li id="zip">' + data.address.zip + '</li>');

                $('<div/>', {html:"results found:", id:"results", style:"margin-top:20px;"}).appendTo('#address-form fieldset');
                $('<ul/>', {
                    'class': 'my-new-list',
                    html: items.join('')
                }).appendTo('#results');
            }

            addressNameSpace.getAddress = function() {

                var data = $("#address-form").serializeObject();//{"firstName":"mike","lastName":"lastName"};

                $.ajax({
                    url: '/webapp/ajax/person',
                    dataType: 'json',
                    type: 'GET',
//                    data: $.toJSON(data),
                    data:$("#address-form").serialize(),
                    processData:false,
                    contentType:'plain/text',
                    success: addressNameSpace.callback
                });
            }

            $("#address").click(function(event) {
                event.preventDefault();
                addressNameSpace.getAddress();
            })

        </script>
    </body>
</html>