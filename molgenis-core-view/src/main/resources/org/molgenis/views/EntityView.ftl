<#macro show entity>
<dl class="dl-horizontal">
<#list entity.fields as field>
<dt>${field.label}</dt><dd><#if entity.get(field.name)?exists>${field.toString(entity)}</#if></dd>
</#list>
</dl>
</#macro>