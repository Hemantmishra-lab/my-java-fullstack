<#import "/common/layout.ftlh" as layout/>
<#import "/spring.ftl" as spring/>
<@layout.page title="${(author.id??)?then('Edit Author','New Author')}" activePage="authors">

<div class="d-flex align-items-center mb-4">
    <a href="${ctx}/authors" class="btn btn-sm btn-outline-secondary me-3"><i class="bi bi-arrow-left"></i></a>
    <h2 class="mb-0"><i class="bi bi-pen text-primary me-2"></i>${(author.id??)?then('Edit','Add')} Author</h2>
</div>

<div class="card border-0 shadow-sm" style="max-width:600px;">
    <div class="card-body p-4">
        <form method="POST" action="${ctx}/authors/save" novalidate>
            <#if author.id??><input type="hidden" name="id" value="${author.id}"></#if>

            <div class="mb-3">
                <label class="form-label fw-semibold">Name *</label>
                <@spring.bind "author.name"/>
                <input type="text" name="name" value="${spring.status.value!''}"
                       class="form-control ${spring.status.errorMessages?has_content?then('is-invalid','')}">
                <#list spring.status.errorMessages as err><div class="invalid-feedback">${err}</div></#list>
            </div>

            <div class="mb-3">
                <label class="form-label fw-semibold">Biography</label>
                <@spring.bind "author.biography"/>
                <textarea name="biography" rows="5"
                          class="form-control">${spring.status.value!''}</textarea>
            </div>

            <div class="d-flex gap-2">
                <button type="submit" class="btn btn-primary px-4"><i class="bi bi-floppy me-1"></i>Save</button>
                <a href="${ctx}/authors" class="btn btn-outline-secondary">Cancel</a>
            </div>
        </form>
    </div>
</div>
</@layout.page>