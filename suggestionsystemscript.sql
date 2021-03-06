USE [master]
GO
/****** Object:  Database [SuggestionDatabase]    Script Date: 10/30/2017 5:28:13 AM ******/
CREATE DATABASE [SuggestionDatabase]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SuggestionDatabase', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\SuggestionDatabase.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'SuggestionDatabase_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\SuggestionDatabase_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [SuggestionDatabase] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SuggestionDatabase].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SuggestionDatabase] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET ARITHABORT OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SuggestionDatabase] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SuggestionDatabase] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET  DISABLE_BROKER 
GO
ALTER DATABASE [SuggestionDatabase] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SuggestionDatabase] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [SuggestionDatabase] SET  MULTI_USER 
GO
ALTER DATABASE [SuggestionDatabase] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SuggestionDatabase] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SuggestionDatabase] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SuggestionDatabase] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [SuggestionDatabase] SET DELAYED_DURABILITY = DISABLED 
GO
USE [SuggestionDatabase]
GO
/****** Object:  User [suggestiondatabse]    Script Date: 10/30/2017 5:28:13 AM ******/
CREATE USER [suggestiondatabse] FOR LOGIN [root123] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [suggestion]    Script Date: 10/30/2017 5:28:13 AM ******/
CREATE USER [suggestion] FOR LOGIN [suggestion] WITH DEFAULT_SCHEMA=[db_owner]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 10/30/2017 5:28:14 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Admin](
	[adminid] [int] IDENTITY(1,1) NOT NULL,
	[adminname] [varchar](50) NULL,
	[adminpassword] [varchar](50) NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[adminid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Cookies]    Script Date: 10/30/2017 5:28:14 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cookies](
	[cookieid] [int] NOT NULL,
	[cookiename] [varchar](50) NULL,
	[userid] [int] NULL,
 CONSTRAINT [PK_Cookies] PRIMARY KEY CLUSTERED 
(
	[cookieid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FileResource]    Script Date: 10/30/2017 5:28:14 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FileResource](
	[fileid] [int] IDENTITY(1,1) NOT NULL,
	[filename] [varchar](50) NULL,
	[filecategory] [varchar](50) NULL,
	[fileauthor] [varchar](50) NULL,
	[filesize] [varchar](50) NULL,
 CONSTRAINT [PK_FileResource] PRIMARY KEY CLUSTERED 
(
	[fileid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PdfResource]    Script Date: 10/30/2017 5:28:14 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PdfResource](
	[pdfid] [int] IDENTITY(1,1) NOT NULL,
	[pdfname] [varchar](50) NULL,
	[pdfcategory] [varchar](50) NULL,
	[pdfauthor] [varchar](50) NULL,
	[pdfsize] [varchar](50) NULL,
 CONSTRAINT [PK_PdfResource] PRIMARY KEY CLUSTERED 
(
	[pdfid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PptResource]    Script Date: 10/30/2017 5:28:14 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PptResource](
	[pptid] [int] IDENTITY(1,1) NOT NULL,
	[pptname] [varchar](50) NULL,
	[pptcategory] [varchar](50) NULL,
	[pptauthor] [varchar](50) NULL,
	[pptsize] [varchar](50) NULL,
 CONSTRAINT [PK_PptResource] PRIMARY KEY CLUSTERED 
(
	[pptid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SuggestionUser]    Script Date: 10/30/2017 5:28:14 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SuggestionUser](
	[userid] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NULL,
	[userpassword] [varchar](50) NULL,
 CONSTRAINT [PK_SuggestionUser] PRIMARY KEY CLUSTERED 
(
	[userid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Cookies]  WITH CHECK ADD  CONSTRAINT [FK_Cookies_SuggestionUser] FOREIGN KEY([userid])
REFERENCES [dbo].[SuggestionUser] ([userid])
GO
ALTER TABLE [dbo].[Cookies] CHECK CONSTRAINT [FK_Cookies_SuggestionUser]
GO
USE [master]
GO
ALTER DATABASE [SuggestionDatabase] SET  READ_WRITE 
GO
