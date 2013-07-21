<#macro button id label onclick style="default" disabled=false method="POST">
<button id="${id}" class="btn<#if style!="default"> btn-${style}</#if><#if disabled> disabled</#if>" onclick="${onclick}">${label}</button>
</#macro>