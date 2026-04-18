<#import "/common/layout.ftlh" as layout/>
<@layout.page title="Authors" activePage="authors">

<div class="d-flex justify-content-between align-items-center mb-3">
    <h2 class="mb-0"><i class="bi bi-pen text-primary me-2"></i>Authors</h2>
    <a href="${ctx}/authors/new" class="btn btn-primary"><i class="bi bi-plus-lg me-1"></i>Add Author</a>
</div>

<div class="card border-0 shadow-sm">
    <div class="card-body p-0">
        <table class="table table-hover align-middle mb-0">
            <thead class="table-dark">
                <tr><th>#</th><th>Name</th><th>Biography</th><th>Actions</th></tr>
            </thead>
            <tbody>
            <#if authors?has_content>
                <#list authors as a>
                <tr>
                    <td class="text-muted small">${a.id}</td>
                    <td><strong>${a.name?html}</strong></td>
                    <td class="small text-muted">${(a.biography?truncate(80))!''}</td>
                    <td>
                        <a href="${ctx}/authors/edit/${a.id}" class="btn btn-sm btn-outline-primary me-1">
                            <i class="bi bi-pencil"></i>
                        </a>
                        <form method="POST" action="${ctx}/authors/delete/${a.id}" class="d-inline">
                            <button type="button" class="btn btn-sm btn-outline-danger"
                                    onclick="confirmDelete(this.form, '${a.name?js_string}')">
                                <i class="bi bi-trash"></i>
                            </button>
                        </form>
                    </td>
                </tr>
                </#list>
            <#else>
                <tr><td colspan="4" class="text-center text-muted py-4">No authors yet.</td></tr>
            </#if>
            </tbody>
        </table>
    </div>
</div>
</@layout.page>