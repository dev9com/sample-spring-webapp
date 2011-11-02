<%@include file="/WEB-INF/jsp/common/page-includes.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title><decorator:title default="Default Title"/></title>
        <meta name="abstract" content="main"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/site/styles/blueprint/screen.css" type="text/css" media="screen, projection"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/site/styles/blueprint/print.css" type="text/css" media="print"/>
        <!--[if lt IE 8]>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/site/styles/blueprint/ie.css" type="text/css" media="screen, projection"/>
        <![endif]-->
        <link href="${pageContext.request.contextPath}/site/styles/base.css" rel="stylesheet" type="text/css"/>
        <decorator:head/>
    </head>
    <body>

        <div class="container">

            <div class="span-24" id="header">
                <a href="${pageContext.request.contextPath}/"><h1><spring:message code="home.page.title"/></h1></a>
            </div>

            <div class="span-20 push-4 last" id="content-body">
                <decorator:body/>
            </div>

            <div class="span-4 first last pull-20">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/twitter/home"><spring:message code="home.twitter.section.header"/></a></li>
                </ul>
            </div>

            <div class="span-24" id="footer">
                &copy;2012 |
                <a href="http://www.dynacrongroup.com" target="_blank">Dynacron Group</a> |
                <a href="<spring:message code="decorator.footer.mikesblog.url"/>" target="_blank"><spring:message code="decorator.footer.mikesblog"/></a> |
                <a href="<spring:message code="decorator.footer.site.url"/>" target="_blank"><spring:message code="decorator.footer.site"/></a>
            </div>
            <c:set var="passedVar"><decorator:getProperty property="page.myvariable"/></c:set>
            <c:if test="${not empty passedVar}">
                You passed '${passedVar}' to the decorator
            </c:if>
        </div>
    </body>
</html>