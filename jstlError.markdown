---
title: jstl Error Resolve
date: 2017-05-17 10:13:28
tags:
---
When u use jstl,u might find two uri path.
Here to remind your,those uris are different.

--(JSTL1.2) should use "http://java.sun.com/jsp/jstl/core" 
--

--(JSTL1.0) should use "http://java.sun.com/jstl/core"
--

What's the difference?
    In version 1.2,you can use EL Expressions you do not need <c:out>. 
  You can directly insert EL expressions onto jsp page like ${propertyName}
    And the web-app version should be 2.4 or above.
    
    So on the constary,JSTL 1.0 is deprecated,and cannot use what i say.