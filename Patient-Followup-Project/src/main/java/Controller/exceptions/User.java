/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.exceptions;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sarah
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByHost", query = "SELECT u FROM User u WHERE u.host = :host"),
    @NamedQuery(name = "User.findByUser", query = "SELECT u FROM User u WHERE u.user = :user"),
    @NamedQuery(name = "User.findBySelectpriv", query = "SELECT u FROM User u WHERE u.selectpriv = :selectpriv"),
    @NamedQuery(name = "User.findByInsertpriv", query = "SELECT u FROM User u WHERE u.insertpriv = :insertpriv"),
    @NamedQuery(name = "User.findByUpdatepriv", query = "SELECT u FROM User u WHERE u.updatepriv = :updatepriv"),
    @NamedQuery(name = "User.findByDeletepriv", query = "SELECT u FROM User u WHERE u.deletepriv = :deletepriv"),
    @NamedQuery(name = "User.findByCreatepriv", query = "SELECT u FROM User u WHERE u.createpriv = :createpriv"),
    @NamedQuery(name = "User.findByDroppriv", query = "SELECT u FROM User u WHERE u.droppriv = :droppriv"),
    @NamedQuery(name = "User.findByReloadpriv", query = "SELECT u FROM User u WHERE u.reloadpriv = :reloadpriv"),
    @NamedQuery(name = "User.findByShutdownpriv", query = "SELECT u FROM User u WHERE u.shutdownpriv = :shutdownpriv"),
    @NamedQuery(name = "User.findByProcesspriv", query = "SELECT u FROM User u WHERE u.processpriv = :processpriv"),
    @NamedQuery(name = "User.findByFilepriv", query = "SELECT u FROM User u WHERE u.filepriv = :filepriv"),
    @NamedQuery(name = "User.findByGrantpriv", query = "SELECT u FROM User u WHERE u.grantpriv = :grantpriv"),
    @NamedQuery(name = "User.findByReferencespriv", query = "SELECT u FROM User u WHERE u.referencespriv = :referencespriv"),
    @NamedQuery(name = "User.findByIndexpriv", query = "SELECT u FROM User u WHERE u.indexpriv = :indexpriv"),
    @NamedQuery(name = "User.findByAlterpriv", query = "SELECT u FROM User u WHERE u.alterpriv = :alterpriv"),
    @NamedQuery(name = "User.findByShowdbpriv", query = "SELECT u FROM User u WHERE u.showdbpriv = :showdbpriv"),
    @NamedQuery(name = "User.findBySuperpriv", query = "SELECT u FROM User u WHERE u.superpriv = :superpriv"),
    @NamedQuery(name = "User.findByCreatetmptablepriv", query = "SELECT u FROM User u WHERE u.createtmptablepriv = :createtmptablepriv"),
    @NamedQuery(name = "User.findByLocktablespriv", query = "SELECT u FROM User u WHERE u.locktablespriv = :locktablespriv"),
    @NamedQuery(name = "User.findByExecutepriv", query = "SELECT u FROM User u WHERE u.executepriv = :executepriv"),
    @NamedQuery(name = "User.findByReplslavepriv", query = "SELECT u FROM User u WHERE u.replslavepriv = :replslavepriv"),
    @NamedQuery(name = "User.findByReplclientpriv", query = "SELECT u FROM User u WHERE u.replclientpriv = :replclientpriv"),
    @NamedQuery(name = "User.findByCreateviewpriv", query = "SELECT u FROM User u WHERE u.createviewpriv = :createviewpriv"),
    @NamedQuery(name = "User.findByShowviewpriv", query = "SELECT u FROM User u WHERE u.showviewpriv = :showviewpriv"),
    @NamedQuery(name = "User.findByCreateroutinepriv", query = "SELECT u FROM User u WHERE u.createroutinepriv = :createroutinepriv"),
    @NamedQuery(name = "User.findByAlterroutinepriv", query = "SELECT u FROM User u WHERE u.alterroutinepriv = :alterroutinepriv"),
    @NamedQuery(name = "User.findByCreateuserpriv", query = "SELECT u FROM User u WHERE u.createuserpriv = :createuserpriv"),
    @NamedQuery(name = "User.findByEventpriv", query = "SELECT u FROM User u WHERE u.eventpriv = :eventpriv"),
    @NamedQuery(name = "User.findByTriggerpriv", query = "SELECT u FROM User u WHERE u.triggerpriv = :triggerpriv"),
    @NamedQuery(name = "User.findByCreatetablespacepriv", query = "SELECT u FROM User u WHERE u.createtablespacepriv = :createtablespacepriv"),
    @NamedQuery(name = "User.findByDeletehistorypriv", query = "SELECT u FROM User u WHERE u.deletehistorypriv = :deletehistorypriv"),
    @NamedQuery(name = "User.findBySslType", query = "SELECT u FROM User u WHERE u.sslType = :sslType"),
    @NamedQuery(name = "User.findByMaxQuestions", query = "SELECT u FROM User u WHERE u.maxQuestions = :maxQuestions"),
    @NamedQuery(name = "User.findByMaxUpdates", query = "SELECT u FROM User u WHERE u.maxUpdates = :maxUpdates"),
    @NamedQuery(name = "User.findByMaxConnections", query = "SELECT u FROM User u WHERE u.maxConnections = :maxConnections"),
    @NamedQuery(name = "User.findByMaxUserConnections", query = "SELECT u FROM User u WHERE u.maxUserConnections = :maxUserConnections"),
    @NamedQuery(name = "User.findByPasswordExpired", query = "SELECT u FROM User u WHERE u.passwordExpired = :passwordExpired"),
    @NamedQuery(name = "User.findByIsRole", query = "SELECT u FROM User u WHERE u.isRole = :isRole"),
    @NamedQuery(name = "User.findByMaxStatementTime", query = "SELECT u FROM User u WHERE u.maxStatementTime = :maxStatementTime")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Host")
    private String host;
    @Basic(optional = false)
    @Column(name = "User")
    private String user;
    @Lob
    @Column(name = "Password")
    private String password;
    @Column(name = "Select_priv")
    private String selectpriv;
    @Column(name = "Insert_priv")
    private String insertpriv;
    @Column(name = "Update_priv")
    private String updatepriv;
    @Column(name = "Delete_priv")
    private String deletepriv;
    @Column(name = "Create_priv")
    private String createpriv;
    @Column(name = "Drop_priv")
    private String droppriv;
    @Column(name = "Reload_priv")
    private String reloadpriv;
    @Column(name = "Shutdown_priv")
    private String shutdownpriv;
    @Column(name = "Process_priv")
    private String processpriv;
    @Column(name = "File_priv")
    private String filepriv;
    @Column(name = "Grant_priv")
    private String grantpriv;
    @Column(name = "References_priv")
    private String referencespriv;
    @Column(name = "Index_priv")
    private String indexpriv;
    @Column(name = "Alter_priv")
    private String alterpriv;
    @Column(name = "Show_db_priv")
    private String showdbpriv;
    @Column(name = "Super_priv")
    private String superpriv;
    @Column(name = "Create_tmp_table_priv")
    private String createtmptablepriv;
    @Column(name = "Lock_tables_priv")
    private String locktablespriv;
    @Column(name = "Execute_priv")
    private String executepriv;
    @Column(name = "Repl_slave_priv")
    private String replslavepriv;
    @Column(name = "Repl_client_priv")
    private String replclientpriv;
    @Column(name = "Create_view_priv")
    private String createviewpriv;
    @Column(name = "Show_view_priv")
    private String showviewpriv;
    @Column(name = "Create_routine_priv")
    private String createroutinepriv;
    @Column(name = "Alter_routine_priv")
    private String alterroutinepriv;
    @Column(name = "Create_user_priv")
    private String createuserpriv;
    @Column(name = "Event_priv")
    private String eventpriv;
    @Column(name = "Trigger_priv")
    private String triggerpriv;
    @Column(name = "Create_tablespace_priv")
    private String createtablespacepriv;
    @Column(name = "Delete_history_priv")
    private String deletehistorypriv;
    @Column(name = "ssl_type")
    private String sslType;
    @Basic(optional = false)
    @Lob
    @Column(name = "ssl_cipher")
    private String sslCipher;
    @Basic(optional = false)
    @Lob
    @Column(name = "x509_issuer")
    private String x509Issuer;
    @Basic(optional = false)
    @Lob
    @Column(name = "x509_subject")
    private String x509Subject;
    @Basic(optional = false)
    @Column(name = "max_questions")
    private long maxQuestions;
    @Basic(optional = false)
    @Column(name = "max_updates")
    private long maxUpdates;
    @Basic(optional = false)
    @Column(name = "max_connections")
    private long maxConnections;
    @Basic(optional = false)
    @Column(name = "max_user_connections")
    private long maxUserConnections;
    @Basic(optional = false)
    @Lob
    @Column(name = "plugin")
    private String plugin;
    @Basic(optional = false)
    @Lob
    @Column(name = "authentication_string")
    private String authenticationString;
    @Basic(optional = false)
    @Column(name = "password_expired")
    private String passwordExpired;
    @Column(name = "is_role")
    private String isRole;
    @Basic(optional = false)
    @Lob
    @Column(name = "default_role")
    private String defaultRole;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "max_statement_time")
    private BigDecimal maxStatementTime;

    public User() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSelectpriv() {
        return selectpriv;
    }

    public void setSelectpriv(String selectpriv) {
        this.selectpriv = selectpriv;
    }

    public String getInsertpriv() {
        return insertpriv;
    }

    public void setInsertpriv(String insertpriv) {
        this.insertpriv = insertpriv;
    }

    public String getUpdatepriv() {
        return updatepriv;
    }

    public void setUpdatepriv(String updatepriv) {
        this.updatepriv = updatepriv;
    }

    public String getDeletepriv() {
        return deletepriv;
    }

    public void setDeletepriv(String deletepriv) {
        this.deletepriv = deletepriv;
    }

    public String getCreatepriv() {
        return createpriv;
    }

    public void setCreatepriv(String createpriv) {
        this.createpriv = createpriv;
    }

    public String getDroppriv() {
        return droppriv;
    }

    public void setDroppriv(String droppriv) {
        this.droppriv = droppriv;
    }

    public String getReloadpriv() {
        return reloadpriv;
    }

    public void setReloadpriv(String reloadpriv) {
        this.reloadpriv = reloadpriv;
    }

    public String getShutdownpriv() {
        return shutdownpriv;
    }

    public void setShutdownpriv(String shutdownpriv) {
        this.shutdownpriv = shutdownpriv;
    }

    public String getProcesspriv() {
        return processpriv;
    }

    public void setProcesspriv(String processpriv) {
        this.processpriv = processpriv;
    }

    public String getFilepriv() {
        return filepriv;
    }

    public void setFilepriv(String filepriv) {
        this.filepriv = filepriv;
    }

    public String getGrantpriv() {
        return grantpriv;
    }

    public void setGrantpriv(String grantpriv) {
        this.grantpriv = grantpriv;
    }

    public String getReferencespriv() {
        return referencespriv;
    }

    public void setReferencespriv(String referencespriv) {
        this.referencespriv = referencespriv;
    }

    public String getIndexpriv() {
        return indexpriv;
    }

    public void setIndexpriv(String indexpriv) {
        this.indexpriv = indexpriv;
    }

    public String getAlterpriv() {
        return alterpriv;
    }

    public void setAlterpriv(String alterpriv) {
        this.alterpriv = alterpriv;
    }

    public String getShowdbpriv() {
        return showdbpriv;
    }

    public void setShowdbpriv(String showdbpriv) {
        this.showdbpriv = showdbpriv;
    }

    public String getSuperpriv() {
        return superpriv;
    }

    public void setSuperpriv(String superpriv) {
        this.superpriv = superpriv;
    }

    public String getCreatetmptablepriv() {
        return createtmptablepriv;
    }

    public void setCreatetmptablepriv(String createtmptablepriv) {
        this.createtmptablepriv = createtmptablepriv;
    }

    public String getLocktablespriv() {
        return locktablespriv;
    }

    public void setLocktablespriv(String locktablespriv) {
        this.locktablespriv = locktablespriv;
    }

    public String getExecutepriv() {
        return executepriv;
    }

    public void setExecutepriv(String executepriv) {
        this.executepriv = executepriv;
    }

    public String getReplslavepriv() {
        return replslavepriv;
    }

    public void setReplslavepriv(String replslavepriv) {
        this.replslavepriv = replslavepriv;
    }

    public String getReplclientpriv() {
        return replclientpriv;
    }

    public void setReplclientpriv(String replclientpriv) {
        this.replclientpriv = replclientpriv;
    }

    public String getCreateviewpriv() {
        return createviewpriv;
    }

    public void setCreateviewpriv(String createviewpriv) {
        this.createviewpriv = createviewpriv;
    }

    public String getShowviewpriv() {
        return showviewpriv;
    }

    public void setShowviewpriv(String showviewpriv) {
        this.showviewpriv = showviewpriv;
    }

    public String getCreateroutinepriv() {
        return createroutinepriv;
    }

    public void setCreateroutinepriv(String createroutinepriv) {
        this.createroutinepriv = createroutinepriv;
    }

    public String getAlterroutinepriv() {
        return alterroutinepriv;
    }

    public void setAlterroutinepriv(String alterroutinepriv) {
        this.alterroutinepriv = alterroutinepriv;
    }

    public String getCreateuserpriv() {
        return createuserpriv;
    }

    public void setCreateuserpriv(String createuserpriv) {
        this.createuserpriv = createuserpriv;
    }

    public String getEventpriv() {
        return eventpriv;
    }

    public void setEventpriv(String eventpriv) {
        this.eventpriv = eventpriv;
    }

    public String getTriggerpriv() {
        return triggerpriv;
    }

    public void setTriggerpriv(String triggerpriv) {
        this.triggerpriv = triggerpriv;
    }

    public String getCreatetablespacepriv() {
        return createtablespacepriv;
    }

    public void setCreatetablespacepriv(String createtablespacepriv) {
        this.createtablespacepriv = createtablespacepriv;
    }

    public String getDeletehistorypriv() {
        return deletehistorypriv;
    }

    public void setDeletehistorypriv(String deletehistorypriv) {
        this.deletehistorypriv = deletehistorypriv;
    }

    public String getSslType() {
        return sslType;
    }

    public void setSslType(String sslType) {
        this.sslType = sslType;
    }

    public String getSslCipher() {
        return sslCipher;
    }

    public void setSslCipher(String sslCipher) {
        this.sslCipher = sslCipher;
    }

    public String getX509Issuer() {
        return x509Issuer;
    }

    public void setX509Issuer(String x509Issuer) {
        this.x509Issuer = x509Issuer;
    }

    public String getX509Subject() {
        return x509Subject;
    }

    public void setX509Subject(String x509Subject) {
        this.x509Subject = x509Subject;
    }

    public long getMaxQuestions() {
        return maxQuestions;
    }

    public void setMaxQuestions(long maxQuestions) {
        this.maxQuestions = maxQuestions;
    }

    public long getMaxUpdates() {
        return maxUpdates;
    }

    public void setMaxUpdates(long maxUpdates) {
        this.maxUpdates = maxUpdates;
    }

    public long getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(long maxConnections) {
        this.maxConnections = maxConnections;
    }

    public long getMaxUserConnections() {
        return maxUserConnections;
    }

    public void setMaxUserConnections(long maxUserConnections) {
        this.maxUserConnections = maxUserConnections;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public String getAuthenticationString() {
        return authenticationString;
    }

    public void setAuthenticationString(String authenticationString) {
        this.authenticationString = authenticationString;
    }

    public String getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(String passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public String getIsRole() {
        return isRole;
    }

    public void setIsRole(String isRole) {
        this.isRole = isRole;
    }

    public String getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(String defaultRole) {
        this.defaultRole = defaultRole;
    }

    public BigDecimal getMaxStatementTime() {
        return maxStatementTime;
    }

    public void setMaxStatementTime(BigDecimal maxStatementTime) {
        this.maxStatementTime = maxStatementTime;
    }
    
}
