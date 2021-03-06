/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.wish.list.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.wish.list.model.CommerceWishListItem;
import com.liferay.commerce.wish.list.model.CommerceWishListItemModel;
import com.liferay.commerce.wish.list.model.CommerceWishListItemSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CommerceWishListItem service. Represents a row in the &quot;CommerceWishListItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CommerceWishListItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceWishListItemImpl}.
 * </p>
 *
 * @author Andrea Di Giorgi
 * @see CommerceWishListItemImpl
 * @see CommerceWishListItem
 * @see CommerceWishListItemModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CommerceWishListItemModelImpl extends BaseModelImpl<CommerceWishListItem>
	implements CommerceWishListItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce wish list item model instance should use the {@link CommerceWishListItem} interface instead.
	 */
	public static final String TABLE_NAME = "CommerceWishListItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "commerceWishListItemId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "commerceWishListId", Types.BIGINT },
			{ "CPInstanceUuid", Types.VARCHAR },
			{ "CProductId", Types.BIGINT },
			{ "json", Types.CLOB }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commerceWishListItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceWishListId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CPInstanceUuid", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CProductId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("json", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE = "create table CommerceWishListItem (commerceWishListItemId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceWishListId LONG,CPInstanceUuid VARCHAR(75) null,CProductId LONG,json TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table CommerceWishListItem";
	public static final String ORDER_BY_JPQL = " ORDER BY commerceWishListItem.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CommerceWishListItem.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.wish.list.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.wish.list.model.CommerceWishListItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.wish.list.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.wish.list.model.CommerceWishListItem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.wish.list.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.wish.list.model.CommerceWishListItem"),
			true);
	public static final long CPINSTANCEUUID_COLUMN_BITMASK = 1L;
	public static final long CPRODUCTID_COLUMN_BITMASK = 2L;
	public static final long COMMERCEWISHLISTID_COLUMN_BITMASK = 4L;
	public static final long CREATEDATE_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceWishListItem toModel(
		CommerceWishListItemSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommerceWishListItem model = new CommerceWishListItemImpl();

		model.setCommerceWishListItemId(soapModel.getCommerceWishListItemId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceWishListId(soapModel.getCommerceWishListId());
		model.setCPInstanceUuid(soapModel.getCPInstanceUuid());
		model.setCProductId(soapModel.getCProductId());
		model.setJson(soapModel.getJson());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceWishListItem> toModels(
		CommerceWishListItemSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommerceWishListItem> models = new ArrayList<CommerceWishListItem>(soapModels.length);

		for (CommerceWishListItemSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.wish.list.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.wish.list.model.CommerceWishListItem"));

	public CommerceWishListItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceWishListItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceWishListItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceWishListItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceWishListItem.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceWishListItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commerceWishListItemId", getCommerceWishListItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("commerceWishListId", getCommerceWishListId());
		attributes.put("CPInstanceUuid", getCPInstanceUuid());
		attributes.put("CProductId", getCProductId());
		attributes.put("json", getJson());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commerceWishListItemId = (Long)attributes.get(
				"commerceWishListItemId");

		if (commerceWishListItemId != null) {
			setCommerceWishListItemId(commerceWishListItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long commerceWishListId = (Long)attributes.get("commerceWishListId");

		if (commerceWishListId != null) {
			setCommerceWishListId(commerceWishListId);
		}

		String CPInstanceUuid = (String)attributes.get("CPInstanceUuid");

		if (CPInstanceUuid != null) {
			setCPInstanceUuid(CPInstanceUuid);
		}

		Long CProductId = (Long)attributes.get("CProductId");

		if (CProductId != null) {
			setCProductId(CProductId);
		}

		String json = (String)attributes.get("json");

		if (json != null) {
			setJson(json);
		}
	}

	@JSON
	@Override
	public long getCommerceWishListItemId() {
		return _commerceWishListItemId;
	}

	@Override
	public void setCommerceWishListItemId(long commerceWishListItemId) {
		_commerceWishListItemId = commerceWishListItemId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCommerceWishListId() {
		return _commerceWishListId;
	}

	@Override
	public void setCommerceWishListId(long commerceWishListId) {
		_columnBitmask |= COMMERCEWISHLISTID_COLUMN_BITMASK;

		if (!_setOriginalCommerceWishListId) {
			_setOriginalCommerceWishListId = true;

			_originalCommerceWishListId = _commerceWishListId;
		}

		_commerceWishListId = commerceWishListId;
	}

	public long getOriginalCommerceWishListId() {
		return _originalCommerceWishListId;
	}

	@JSON
	@Override
	public String getCPInstanceUuid() {
		if (_CPInstanceUuid == null) {
			return "";
		}
		else {
			return _CPInstanceUuid;
		}
	}

	@Override
	public void setCPInstanceUuid(String CPInstanceUuid) {
		_columnBitmask |= CPINSTANCEUUID_COLUMN_BITMASK;

		if (_originalCPInstanceUuid == null) {
			_originalCPInstanceUuid = _CPInstanceUuid;
		}

		_CPInstanceUuid = CPInstanceUuid;
	}

	public String getOriginalCPInstanceUuid() {
		return GetterUtil.getString(_originalCPInstanceUuid);
	}

	@JSON
	@Override
	public long getCProductId() {
		return _CProductId;
	}

	@Override
	public void setCProductId(long CProductId) {
		_columnBitmask |= CPRODUCTID_COLUMN_BITMASK;

		if (!_setOriginalCProductId) {
			_setOriginalCProductId = true;

			_originalCProductId = _CProductId;
		}

		_CProductId = CProductId;
	}

	public long getOriginalCProductId() {
		return _originalCProductId;
	}

	@JSON
	@Override
	public String getJson() {
		if (_json == null) {
			return "";
		}
		else {
			return _json;
		}
	}

	@Override
	public void setJson(String json) {
		_json = json;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CommerceWishListItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceWishListItem toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CommerceWishListItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommerceWishListItemImpl commerceWishListItemImpl = new CommerceWishListItemImpl();

		commerceWishListItemImpl.setCommerceWishListItemId(getCommerceWishListItemId());
		commerceWishListItemImpl.setGroupId(getGroupId());
		commerceWishListItemImpl.setCompanyId(getCompanyId());
		commerceWishListItemImpl.setUserId(getUserId());
		commerceWishListItemImpl.setUserName(getUserName());
		commerceWishListItemImpl.setCreateDate(getCreateDate());
		commerceWishListItemImpl.setModifiedDate(getModifiedDate());
		commerceWishListItemImpl.setCommerceWishListId(getCommerceWishListId());
		commerceWishListItemImpl.setCPInstanceUuid(getCPInstanceUuid());
		commerceWishListItemImpl.setCProductId(getCProductId());
		commerceWishListItemImpl.setJson(getJson());

		commerceWishListItemImpl.resetOriginalValues();

		return commerceWishListItemImpl;
	}

	@Override
	public int compareTo(CommerceWishListItem commerceWishListItem) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				commerceWishListItem.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommerceWishListItem)) {
			return false;
		}

		CommerceWishListItem commerceWishListItem = (CommerceWishListItem)obj;

		long primaryKey = commerceWishListItem.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CommerceWishListItemModelImpl commerceWishListItemModelImpl = this;

		commerceWishListItemModelImpl._setModifiedDate = false;

		commerceWishListItemModelImpl._originalCommerceWishListId = commerceWishListItemModelImpl._commerceWishListId;

		commerceWishListItemModelImpl._setOriginalCommerceWishListId = false;

		commerceWishListItemModelImpl._originalCPInstanceUuid = commerceWishListItemModelImpl._CPInstanceUuid;

		commerceWishListItemModelImpl._originalCProductId = commerceWishListItemModelImpl._CProductId;

		commerceWishListItemModelImpl._setOriginalCProductId = false;

		commerceWishListItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceWishListItem> toCacheModel() {
		CommerceWishListItemCacheModel commerceWishListItemCacheModel = new CommerceWishListItemCacheModel();

		commerceWishListItemCacheModel.commerceWishListItemId = getCommerceWishListItemId();

		commerceWishListItemCacheModel.groupId = getGroupId();

		commerceWishListItemCacheModel.companyId = getCompanyId();

		commerceWishListItemCacheModel.userId = getUserId();

		commerceWishListItemCacheModel.userName = getUserName();

		String userName = commerceWishListItemCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceWishListItemCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceWishListItemCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceWishListItemCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceWishListItemCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commerceWishListItemCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceWishListItemCacheModel.commerceWishListId = getCommerceWishListId();

		commerceWishListItemCacheModel.CPInstanceUuid = getCPInstanceUuid();

		String CPInstanceUuid = commerceWishListItemCacheModel.CPInstanceUuid;

		if ((CPInstanceUuid != null) && (CPInstanceUuid.length() == 0)) {
			commerceWishListItemCacheModel.CPInstanceUuid = null;
		}

		commerceWishListItemCacheModel.CProductId = getCProductId();

		commerceWishListItemCacheModel.json = getJson();

		String json = commerceWishListItemCacheModel.json;

		if ((json != null) && (json.length() == 0)) {
			commerceWishListItemCacheModel.json = null;
		}

		return commerceWishListItemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{commerceWishListItemId=");
		sb.append(getCommerceWishListItemId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", commerceWishListId=");
		sb.append(getCommerceWishListId());
		sb.append(", CPInstanceUuid=");
		sb.append(getCPInstanceUuid());
		sb.append(", CProductId=");
		sb.append(getCProductId());
		sb.append(", json=");
		sb.append(getJson());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.liferay.commerce.wish.list.model.CommerceWishListItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commerceWishListItemId</column-name><column-value><![CDATA[");
		sb.append(getCommerceWishListItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commerceWishListId</column-name><column-value><![CDATA[");
		sb.append(getCommerceWishListId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPInstanceUuid</column-name><column-value><![CDATA[");
		sb.append(getCPInstanceUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CProductId</column-name><column-value><![CDATA[");
		sb.append(getCProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>json</column-name><column-value><![CDATA[");
		sb.append(getJson());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CommerceWishListItem.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CommerceWishListItem.class, ModelWrapper.class
		};
	private long _commerceWishListItemId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceWishListId;
	private long _originalCommerceWishListId;
	private boolean _setOriginalCommerceWishListId;
	private String _CPInstanceUuid;
	private String _originalCPInstanceUuid;
	private long _CProductId;
	private long _originalCProductId;
	private boolean _setOriginalCProductId;
	private String _json;
	private long _columnBitmask;
	private CommerceWishListItem _escapedModel;
}