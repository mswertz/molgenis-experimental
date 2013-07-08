<#--
implementation notes:
* for nested collections we use List because that allows extra lazy load.
* we don't use CascadeType=persist|merge on associations because of performance and other problems
* 
-->
<#include "GeneratorHelper.ftl">
package ${package};

import org.springframework.data.repository.CrudRepository;

public interface ${Name(entity)}Repository extends CrudRepository<${Name(entity)},Integer>
{
}