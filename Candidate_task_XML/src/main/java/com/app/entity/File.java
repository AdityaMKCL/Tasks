package com.app.entity;

public class File{
	
	private Long fid;
	
	private byte[] file;
	
	private Candidate candi;
	
	public Long getFid() {
		return fid;
	}

	public Candidate getCandi() {
		return candi;
	}

	public void setCandi(Candidate candi) {
		this.candi = candi;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
	
}
