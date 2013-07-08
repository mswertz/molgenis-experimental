<#macro alert type>
<div class="alert alert-${type}">
	<button type="button" class="close" data-dismiss="alert">x</button>
	<#nested>
</div>
</#macro>
<#macro success><@alert "success"><#nested></@alert></#macro>
<#macro warn><@alert "warn"><#nested></@alert></#macro>
<#macro info><@alert "info"><#nested></@alert></#macro>
<#macro error><@alert "error"><#nested></@alert></#macro>
<#macro danger><@alert "error"><#nested></@alert></#macro>