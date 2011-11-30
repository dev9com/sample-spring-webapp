<%@include file="/WEB-INF/jsp/common/page-includes.jspf" %>
<html>
    <head>
        <title><spring:message code="home.browser.title"/></title>
        <meta name="decorator" content="main-rtl"/>
        <%@include file="/WEB-INF/jsp/common/common-head-elements.jspf" %>
    </head>
    <body>
        <h2 dir="rtl"><spring:message code="home.paragraph.header"/></h2>

        <h3>RTL</h3>

        <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vitae felis libero. Praesent ultrices porttitor magna, sed fringilla metus pharetra vitae. Vestibulum gravida volutpat nunc eu pretium. Donec eget est erat, vitae luctus diam.
            Aliquam laoreet laoreet dui mollis interdum. Donec lobortis, sapien ac bibendum suscipit, turpis nibh laoreet felis, non tempus sem ipsum nec magna. Quisque vehicula, massa in mattis volutpat, elit leo congue metus, eget pellentesque nunc
            turpis
            vel nisl. Mauris eros nisl, convallis tempor tristique sed, tempor eget libero. Suspendisse ac nulla sed nisi mattis volutpat accumsan id elit.
        </p>

        <h2 dir="rtl"><spring:message code="home.twitter.section.header"/></h2>

        <h3 dir="rtl"><spring:message code="home.twitter.section.subheader"/></h3>

        <p>
            <a href="${pageContext.request.contextPath}/twitter/home"><spring:message code="home.twitter.search.link"/></a>
        </p>

        <h2><spring:message code="home.exception.section.header"/></h2>

        <p>
            <a href="${pageContext.request.contextPath}/exception"><spring:message code="home.exception.first"/></a>
        </p>

        <p>
            <a href="${pageContext.request.contextPath}/exception-and-catch"><spring:message code="home.exception.second"/></a>
        </p>

        <h2>Person Pages</h2>

        <p>
            <a href="${pageContext.request.contextPath}/person">Goto Person Page</a>
        </p>

        <h2>Sitemesh examples</h2>
        <a href="${pageContext.request.contextPath}/undecorated">Undecorated Page (by default)</a>

        <h2>@Configuration bean example</h2>

        <p>
            App Name: ${appName}, App Version: ${appVersion}
        </p>
    </body>
</html>