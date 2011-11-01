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

            var addressNameSpace = {};

            addressNameSpace.callback = function(data) {
                var items = [];

                $.each(data, function(key, val) {
                    items.push('<li id="' + key + '">' + val + '</li>');
                });

                $('<ul/>', {
                    'class': 'my-new-list',
                    html: items.join('')
                }).appendTo('body');
            }

            addressNameSpace.getAddress = function() {
                $.getJSON('/webapp/ajax/person', $("#address-form").serialize(), addressNameSpace.callback);
            }

            $("#address").click(function(event) {
                event.preventDefault();
                addressNameSpace.getAddress();
            })

        </script>
    </body>
</html>