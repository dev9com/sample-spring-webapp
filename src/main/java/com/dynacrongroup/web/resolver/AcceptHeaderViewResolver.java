package com.dynacrongroup.web.resolver;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.File;
import java.util.Locale;

public class AcceptHeaderViewResolver extends InternalResourceViewResolver {

    private String rtlFileSuffix = "_rtl";

    public void setRtlFileSuffix(String rtlFileSuffix) {
        this.rtlFileSuffix = rtlFileSuffix;
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {

        StringBuilder adjustedViewName = new StringBuilder(viewName);
        if (isRightToLeftLanguage(locale)) {
            adjustedViewName.append(getRtlFileSuffix());
        }

        String adjustedViewNameString = adjustedViewName.toString();

        String viewFile = getServletContext().getRealPath(this.getPrefix() + adjustedViewNameString + this.getSuffix());
        File reqFile = new File(viewFile);
        View foundView;
        if (!reqFile.exists()) {
            foundView = null;
        } else {
            foundView = super.resolveViewName(adjustedViewNameString, locale);
        }

        return foundView;
    }

    private boolean isRightToLeftLanguage(Locale locale) {
        String lang = locale.getLanguage();
        return ("he".equals(lang) || "iw".equals(lang) || "ar".equals(lang) || "fa".equals(lang) || "ur".equals(lang));
    }

    private String getRtlFileSuffix() {
        return rtlFileSuffix;
    }
}
