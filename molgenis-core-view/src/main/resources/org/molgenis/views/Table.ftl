<#macro table entities>		
<table class="table table-striped table-condensed">
	<thead>
		<tr>
<#list entities as entity>
	<#list entity.fields as field>
			<th>${field.label}</th>
	</#list>
	<#break/>
</#list>
		</tr>
	</thead>
	<tbody>
<#list entities as entity>
		<tr>
<#list entity.fields as field>
			<td>${field.toString(entity)}</td>
</#list>
		</tr>
</#list>
	</tbody>
</table>
</#macro>