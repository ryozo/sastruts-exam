package jp.sastruts.exam.service;

import jp.sastruts.exam.entity.Systemlog;
import jp.sastruts.exam.service.dto.LogInfo;

import org.seasar.extension.jdbc.service.S2AbstractService;

/**
 * SystemLog関連の処理を担当するサービスクラスです。
 * @author W.Ryozo
 *
 */
public class LogService extends S2AbstractService<Systemlog>{
	
	public Systemlog writeLog(LogInfo logInfo) {
		Systemlog log = new Systemlog();
		log.preinfo = logInfo.preInfo;
		log.postinfo = logInfo.postInfo;
		
		insert(log);
		return log;
	}
	
}
